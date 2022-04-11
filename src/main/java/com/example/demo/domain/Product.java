package com.example.demo.domain;

import com.example.demo.crosscutting.api.exception.handlers.BaseApplicationException;
import com.example.demo.validations.EntityValidator;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product implements EntityValidator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Override
    public void validate() {
        List<String> validationErrors = new ArrayList<>();
        if (isNull(this.getName()) || this.getName().isEmpty()) {
            validationErrors.add("Name cannot be null or empty");
        }
        if (validationErrors.size() > 0) {
            throw new ProductException(validationErrors);
        }
    }
}

class ProductException extends BaseApplicationException {
    public ProductException(String message) {
        super(message);
    }

    public ProductException(List<String> ve) {
        super(ve);
    }

    public ProductException() {
        super();
    }
}
