package org.generation.deployproduct.services;

import org.generation.deployproduct.repository.Entity.Item;
import java.util.List;

public interface productColor {

    productColor save(productColor productcolor);
    void delete(int productcolorId);
    List<productColor> all();
    productColor findById(int productcolorId);
}
