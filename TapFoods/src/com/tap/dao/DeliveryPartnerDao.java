package com.tap.dao;

import java.util.List;

import com.tap.model.DeliveryPartner;

public interface DeliveryPartnerDao {
    
    void addDeliveryPartner(DeliveryPartner partner);
    DeliveryPartner getDeliveryPartner(int partnerId);
    void updateDeliveryPartner(DeliveryPartner partner);
    void deleteDeliveryPartner(int partnerId);
    List<DeliveryPartner> getAllDeliveryPartners();
    
}
