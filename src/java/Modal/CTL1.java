package Modal;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author upekhansaja
 */
public class CTL1 extends SimpleTagSupport {
    
    private String value;
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
//        System.out.println("doTag func called..!");

        JspContext context = getJspContext();
        context.getOut().write(getValue());
        
    }
    
}
