package com.starterkit.springboot.brs.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Embedded;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Experience {
        private String name;
        private Integer years;
}