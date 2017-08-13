package com.Spring.City.algoritm;

import com.Spring.City.model.CityDistance;

import java.util.*;

public class TestDijkstraAlgorithm {

    private List<Vertex> nodes;
    private List<Edge> edges;
    private Integer minDistance = 0;
    private String fromCity;
    private String toCity;
    private int toCityIndex;
    private int fromCityIndex;
    private LinkedList<Vertex> path;

    public TestDijkstraAlgorithm(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public void execute(List<CityDistance> cities) {

        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        String[] citiesAll = getCitiesAll(cities);

        for (String aCitiesAll : citiesAll) {
            Vertex location = new Vertex(aCitiesAll, aCitiesAll);
            nodes.add(location);
        }

        cities = getConvertList(cities, nodes);
        for (int i = 0; i < cities.size(); i++) {
            addLane("Edge_" + i,
                    Integer.valueOf(cities.get(i).getCityA()),
                    Integer.valueOf(cities.get(i).getCityB()),
                    cities.get(i).getDistance());
        }

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(fromCityIndex));
        path = dijkstra.getPath(nodes.get(toCityIndex));
        for (Map.Entry d : dijkstra.getDistance().entrySet()) {
            if (d.getKey().toString().equals(toCity))
                minDistance = (Integer) d.getValue();
        }
    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }

    private List<CityDistance> getConvertList(List<CityDistance> cities, List<Vertex> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            for (CityDistance city : cities) {
                if (city.getCityA().equals(nodes.get(i).getName())) {
                    city.setCityA(String.valueOf(i));
                }
                if (city.getCityB().equals(nodes.get(i).getName())) {
                    city.setCityB(String.valueOf(i));
                }
                if (toCity.equals(nodes.get(i).getName())) {
                    toCityIndex = i;
                }
                if (fromCity.equals(nodes.get(i).getName())) {
                    fromCityIndex = i;
                }
            }
        }
        return cities;
    }

    public Integer getMinDistance() {
        return minDistance;
    }

    public LinkedList<Vertex> getPath() {
        return path;
    }

    private String[] getCitiesAll(List<CityDistance> cities) {
        Set<String> set=new LinkedHashSet<String>();
        for (CityDistance cityDistance : cities) {
            set.add(cityDistance.getCityA());
            set.add(cityDistance.getCityB());
        }
        return set.toArray(new String[set.size()]);
    }
}


