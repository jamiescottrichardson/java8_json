package com.ibm.cic.br.seeds;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Customer extends Prospect {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date conversionDate;

    public Customer(Prospect prospect){
        try{
            BeanUtils.copyProperties(this, prospect);
        }catch(InvocationTargetException | IllegalAccessException e){
            System.err.println("Unable to copy properties.");
        }

        this.conversionDate = new Date();
    }

    public Date getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(Date conversionDate) {
        this.conversionDate = conversionDate;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            return "{}";
        }
    }
}
