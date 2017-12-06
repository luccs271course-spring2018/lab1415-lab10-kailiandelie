package edu.luc.cs271.country;

import java.awt.*;
import java.net.*;
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;

public class CountryCodes {

  static final String AT = "Austria";
  static final String DE = "Germany";
  static final String CZ = "Czechia";
  static final String SK = "Slovakia";
  static final String HU = "Hungary";
  static final String SI = "Slovenia";
  static final String IT = "Italy";
  static final String CH = "Switzerland";

  Graph<String, DefaultEdge> myMap;

  public CountryCodes(Graph<String, DefaultEdge> myMap) {
    this.myMap = myMap;
  }

  public Graph<String, DefaultEdge> returnMap() {

    myMap = new SimpleGraph<>(DefaultEdge.class);

    myMap.addVertex(AT);
    myMap.addVertex(DE);
    myMap.addVertex(CZ);
    myMap.addVertex(SK);
    myMap.addVertex(HU);
    myMap.addVertex(SI);
    myMap.addVertex(IT);
    myMap.addVertex(CH);

    myMap.addEdge(AT, DE);
    myMap.addEdge(AT, CZ);
    myMap.addEdge(DE, CZ);
    myMap.addEdge(AT, SK);
    myMap.addEdge(CZ, SK);
    myMap.addEdge(AT, HU);
    myMap.addEdge(SK, HU);
    myMap.addEdge(AT, SI);
    myMap.addEdge(HU, SI);
    myMap.addEdge(AT, IT);
    myMap.addEdge(SI, IT);
    myMap.addEdge(AT, CH);
    myMap.addEdge(IT, CH);
    myMap.addEdge(CH, DE);

    return myMap;
  }

  public void breadth() {
    final Iterator<String> bf = new BreadthFirstIterator<>(myMap, AT);
    int count = 0;
    while (bf.hasNext() && count < 9) {
      final String country = bf.next();
      System.out.println(country);
      count++;
    }
  }

  public void closest() {
    final Iterator<String> cf = new ClosestFirstIterator<>(myMap, AT);
    int count = 0;
    while (cf.hasNext() && count < 9) {
      final String country = cf.next();
      System.out.println(country);
      count++;
    }
  }

  public void depth() {
    final Iterator<String> df = new DepthFirstIterator<>(myMap, AT);
    int count = 0;
    while (df.hasNext() && count < 9) {
      final String country = df.next();
      System.out.println(country);
      count++;
    }
  }

  public void random() {
    final Iterator<String> rw = new RandomWalkIterator<>(myMap, AT);
    int count = 0;
    while (rw.hasNext() && count < 9) {
      final String country = rw.next();
      System.out.println(country);
      count++;
    }
  }
}
