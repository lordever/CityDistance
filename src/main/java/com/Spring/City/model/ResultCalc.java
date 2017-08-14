package com.Spring.City.model;

import com.Spring.City.algoritm.Vertex;

import java.util.LinkedList;

public class ResultCalc {
    private int minDistance;
    private LinkedList<Vertex> path;

    public ResultCalc(int minDistance, LinkedList<Vertex> path) {
        this.minDistance = minDistance;
        this.path = path;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public LinkedList<Vertex> getPath() {
        return path;
    }
}
