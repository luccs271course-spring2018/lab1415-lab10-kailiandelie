package edu.luc.cs271.country;

import java.awt.*;
import java.net.*;
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.color.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;

public class Main {

  public static void main(final String[] args) throws InterruptedException {

    final Scanner input = new Scanner(System.in);

    Graph<String, DefaultEdge> stringGraph = new SimpleGraph<>(DefaultEdge.class);
    CountryCodes map = new CountryCodes(stringGraph);
    stringGraph = map.returnMap();
    System.out.println(stringGraph);

    map.breadth();
    map.closest();
    map.depth();
    map.random();

    GreedyColoring<String, DefaultEdge> color = new GreedyColoring<>(stringGraph);
    System.out.println(color.getColoring());
  }
}
