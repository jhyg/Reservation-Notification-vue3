package registrationalarmvue.domain;

import java.util.*;
import lombok.*;
import registrationalarmvue.domain.*;
import registrationalarmvue.infra.AbstractEvent;

@Data
@ToString
public class ReservationUpdated extends AbstractEvent {

    private String taskId;
    private String userId;
    private String title;
    private String description;
    private Date dueDate;
}
