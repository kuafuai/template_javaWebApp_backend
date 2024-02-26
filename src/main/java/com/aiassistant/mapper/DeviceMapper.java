package com.aiassistant.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * This interface provides methods to update the status and configuration of a device.
 */
public interface DeviceMapper {
    
    /**
     * Updates the status of a device.
     * 
     * @param deviceIdentifier The identifier of the device.
     * @param deviceStatus The new status of the device.
     */
    void updateDeviceStatus(@Param("deviceIdentifier") String deviceIdentifier, @Param("deviceStatus") String deviceStatus);

    /**
     * Updates the configuration of a device.
     * 
     * @param deviceIdentifier The identifier of the device.
     * @param deviceConfig The new configuration of the device.
     */
    void updateDeviceConfig(@Param("deviceIdentifier") String deviceIdentifier, @Param("deviceConfig") String deviceConfig);
}
