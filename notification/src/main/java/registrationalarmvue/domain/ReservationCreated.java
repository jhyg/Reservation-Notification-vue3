package registrationalarmvue.domain;

import java.util.*;
import lombok.*;
import registrationalarmvue.domain.*;
import registrationalarmvue.infra.AbstractEvent;

@Data
@ToString
public class ReservationCreated extends AbstractEvent {

    private String taskId;
    private String userId;
    private String title;
    private String description;
    private Date dueDate;
}
