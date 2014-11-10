package org.spicydog;

/**
 * Created by spicydog on 10/21/14.
 * Based on http://www.theprojectspot.com/tutorial-post/creating-a-genetic-algorithm-for-beginners/3
 */
public class Calculator {

    static double getCost(Individual individual) {
        double sumCost = 0;
        for (int i = 0; i < Config.geneLength; i++) {
            if(individual.getGene(i))
                sumCost += Config.cost[i];
        }
        return sumCost;
    }


    static double getWeight(Individual individual) {
        double sumWeight = 0;
        for (int i = 0; i < Config.geneLength; i++) {
            if(individual.getGene(i))
                sumWeight += Config.weight[i];
        }
        return sumWeight;
    }

    static int index(int x, int y) {
        int index = 0;
        for (int i = 0; i < Config.nSubsystem; i++) {
            for (int j = 0; j < Config.subsystemSizes[i]; j++) {
                if(i==x && j==y)
                    break;
                index++;
            }
        }
        return index;
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static double getFitness(Individual individual) {
        double fitness = 0;
        // Loop through our individuals genes and compare them to our candidates
        double Rall = 1;
        for (int i = 0; i < Config.nSubsystem; i++) {
            double Ri = 1;
            for (int j = 0; j < Config.subsystemSizes[i]; j++) {
                Ri *= ( 1-Config.reliability[index(i,j)] );
            }
            Rall *= Ri;
        }
        fitness = Rall;

        return fitness;
    }

}