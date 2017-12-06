# COMP 271 002 F17 Lab 10 (Weeks 14-15)

# Team project

Work in teams of two.

# Objectives

An understanding of the following concepts and techniques:

- Graph ADT
- Graph algorithms
- Libraries for working with graphs

# Instructions

In this lab, you will have the opportunity to represent a geographical map as a graph and manipulate this graph in various useful ways.

Specifically:

1. Create a new Gradle-based project based on one of your earlier projects:
    - define a main class
    - define a separate class for the country codes (see below)
    - [JGraphT](http://jgrapht.org/) library dependency - visit [this page](http://search.maven.org/#artifactdetails%7Corg.jgrapht%7Cjgrapht-core%7C1.1.0%7Cjar) and put the dependency information for Gradle in the `dependencies` section of your `build.gradle`
    - don't forget to include a `.gitignore`
    - remove everything you don't need
1. Pick any country in the world (or state/province/territory/department within a single country) that has at least five neighbors with which it shares a border of length > 0 (a corner doesn't count).
1. Define string constants for the country and its immediate neighbors, preferably using the corresponding [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) codes.

        final static String AT = "Austria";
        final static String DE = "Germany";
        ...
1. Using the [JGraphT](http://jgrapht.org/) library, define a graph representing the map limited to the country you picked and its immediate neighbors.
Concretely, define a graph instance, add a vertex for each country, then add an edge for each pair of neighboring countries.
(Because this is an undirected graph, you need to add only *one* edge for each pair of neighboring countries.)

        final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);
        myMap.addVertex(AT);
        myMap.addVertex(DE);
        ...
        myMap.addEdge(AT, DE);
        ...
    Then print the resulting graph.
1. Traverse the graph using the following different traversal algorithms (in `org.grapht.traverse`):
    - `BreadthFirstIterator`
    - `ClosestFirstIterator`
    - `DepthFirstIterator`
    - `RandomWalkIterator`

    For each of these algorithms, use both your central country and a country on the edge of your map as starting points.
    For each combination of country and traversal algorithm, print the resulting iteration sequence.
    
    Example:    
    
        final Iterator<String> bf = new BreadthFirstIterator<>(myMap, DE);
        while (bf.hasNext()) {
          final String country = bf.next();
          ...
        }

    *Written part:* Discuss the differences among the results.
    Does the starting point make a difference?
1. Using JGraphT's `GreedyColoring` or other coloring algorithm, find out how many colors are required to color your map in such a way that no two adjacent countries have the same color.
Concretely, create an instance of `GreedyColoring` for your map, then generate and print the coloring.

    *Fun fact:* For any idealized map (planar graph), this requires [at most four colors](https://en.wikipedia.org/wiki/Four_color_theorem).

    *Written part:* Give two or three examples of how/why a real-world map might require more than four colors.

# Grading

- 0.5 correct project structure (based on Gradle)
- 0.5 submission via GitHub (including multiple commits over time)
- 3 completion of items listed above and correct behavior
- 1 written part (in `Answers.md`)
    - 0.8 responses to the questions embedded above
    - 0.2 grammar, style, formatting

*5 points TOTAL*