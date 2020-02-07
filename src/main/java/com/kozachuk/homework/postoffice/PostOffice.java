package com.kozachuk.homework.postoffice;

import com.kozachuk.homework.postoffice.dto.PackageBox;

import java.util.List;
import java.util.stream.Collectors;

public class PostOffice {
    public boolean validateSize(PackageBox box, PackageBox postofficePackage) {
        if(box == null) throw new NullPointerException("Box cannot be empty");
        if(postofficePackage == null) throw new NullPointerException("Package cannot be empty");

        List<Double> boxSizes        =  box.getSizes().stream().sorted().collect(Collectors.toList());
        List<Double> packageBoxSizer =  postofficePackage.getSizes().stream().sorted().collect(Collectors.toList());

        for(int i=0; i < boxSizes.size(); i++) {
            double boxSize = boxSizes.get(i);
            double packageSize = packageBoxSizer.get(i);

            if(boxSize <= packageSize) return false;
        }

        return true;
    }
}
