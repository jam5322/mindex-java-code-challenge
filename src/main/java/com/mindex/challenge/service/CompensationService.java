package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

import java.util.List;

/**
 * An Interface for the Spring Compensation Service
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
public interface CompensationService {
    /**
     * Creates, saves, and returns a new Compensation
     *
     * @param compensation - The Compensation data to create, save and return
     * @return - A newly created and saved Compensation
     */
    Compensation create(Compensation compensation);

    /**
     * Returns a specific Employee's Compensation based on a given Employee ID
     * @param id - The ID of the Employee for which a Compensation is being searched for
     * @return - The specified Employee's Compensation
     */
    Compensation read(String id);

    /**
     * Returns a List of all currently stored/persisted Compensations
     * @return - A List of all currently stored/persisted Compensations
     */
    List<Compensation> findAll();
}
