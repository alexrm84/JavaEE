package alexrm84.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MainController implements Serializable {

    private static final long serialVersionUID = 8533767790722989390L;

    public String showIndexPage(){
        return "/index.xhtml?faces-redirect=true";
    }
}
