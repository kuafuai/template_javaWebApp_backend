package com.aiassistant.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Represents a fire point with an identifier, coordinates, and area.
 */
@Data
public class FirePoint {

    @NotNull
    @Size(min = 1, message = "ID must not be empty")
    private String id;

    @NotNull
    private Coordinates coordinates;

    @NotNull
    @Positive(message = "Area must be a positive number")
    private Double area;

    /**
     * Constructs a FirePoint with the specified id, coordinates, and area.
     *
     * @param id          the identifier of the fire point
     * @param coordinates the coordinates of the fire point
     * @param area        the area of the fire point
     */
    public FirePoint(String id, Coordinates coordinates, Double area) {
        this.id = id;
        this.coordinates = coordinates;
        this.area = area;
    }

    /**
     * Represents coordinates with latitude and longitude.
     */
    @Data
    public static class Coordinates {
        @NotNull
        private Double latitude;

        @NotNull
        private Double longitude;

        /**
         * Constructs Coordinates with specified latitude and longitude.
         *
         * @param latitude  the latitude
         * @param longitude the longitude
         */
        public Coordinates(Double latitude, Double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
