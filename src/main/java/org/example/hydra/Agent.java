package org.example.hydra;

import lombok.Data;
import lombok.Getter;
@Data
public abstract class Agent  implements HydraAgent{


        private String name;

     private   String realName;
     private String organization;
}
