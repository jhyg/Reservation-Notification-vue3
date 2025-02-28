package registrationalarmvue.domain;

import java.util.*;
import lombok.*;
import registrationalarmvue.domain.*;
import registrationalarmvue.infra.AbstractEvent;

@Data
@ToString
public class ReservationDeleted extends AbstractEvent {

    private String taskId;
}
