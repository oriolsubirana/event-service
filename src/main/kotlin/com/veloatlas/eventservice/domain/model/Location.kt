package com.veloatlas.eventservice.domain.model

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point

data class Location(
    val latitude: Double,
    val longitude: Double
) {
    fun toPoint(): Point {
        val geometryFactory = GeometryFactory()
        return geometryFactory.createPoint(Coordinate(longitude, latitude))
    }
}