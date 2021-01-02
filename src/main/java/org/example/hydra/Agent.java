package org.example.hydra;

import lombok.Data;
import lombok.Getter;
@Data
public abstract class Agent  implements TargetOfAttack{

    private int health= 100;
     private String name;
     private   String realName;
     private String organization;

}
