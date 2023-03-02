package com.starterkit.springboot.brs.controller.v1.request.bootcamp;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.starterkit.springboot.brs.model.bootcamp.Session;
import com.starterkit.springboot.brs.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateBootcampRequest {

    String id;
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "{constraints.NotEmpty.message}")
    @Temporal(TemporalType.DATE)
    Date startSate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "{constraints.NotEmpty.message}")
    @Temporal(TemporalType.DATE)
    Date endDate;
    @NotNull(message = "{constraints.NotEmpty.message}")
    String description;
    @NotNull(message = "{constraints.NotEmpty.message}")
    String longHtml;
    @Lazy
    List<String> userIds; // ["fsdfsdfdsfsd",."fsdfsdfsdfsd"]
    List<String> technologyStackIds;
    List <String> sessionIds;
}
