package com.aiassistant.mapper;

import java.util.List;

/**
 * This interface defines the methods for retrieving position information.
 */
public interface PositionMapper {
    
    /**
     * Retrieves a list of positions.
     * 
     * @return a list of positions
     * @throws Exception if an error occurs while retrieving the positions
     */
    List<String> selectPositionList() throws Exception;
}