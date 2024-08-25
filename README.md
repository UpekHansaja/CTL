# CTL
Custom Tag Libraries (CTL) in Java are a powerful feature used in JavaServer Pages (JSP) to encapsulate reusable functionality. 
They allow developers to create custom tags that can be used in JSP files, reducing the need to embed large amounts of Java code directly in the pages. 
This makes the code cleaner, more maintainable, and easier to read.

et's understand how to create and use custom tag libraries in Java:

### 1. Create the Tag Handler Class

The tag handler class defines the behavior of the custom tag. It extends the `TagSupport` class and overrides its methods.

```java
package Modal;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

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
        JspContext context = getJspContext();
        context.getOut().write(getValue());   
    }    
}

```

### 2. Create the Tag Library Descriptor (TLD) File

The TLD file describes the tags in the library and maps them to their corresponding tag handler classes. It must be placed inside the `WEB-INF` directory.

```xml
<?xml version="1.0" encoding="ISO-8859-1" ?>

<taglib>

    <tlib-version>1.0</tlib-version>
    <jsp-version>1.2</jsp-version>
    <short-name>example</short-name>
    <uri>/WEB-INF/tlds/ctl</uri>

    <name>customPrint</name>
    <tag-class>Modal.CTL1</tag-class>
    <body-content>empty</body-content>
        
    <attribute>
        <name>value</name>
        <required>true</required>
        <type>java.lang.String</type>
    </attribute>

</taglib>
```

### 3. Use the Custom Tag in a JSP File

To use the custom tag in a JSP file, declare the tag library using the `<%@ taglib %>` directive and then use the custom tag.

```jsp
<%@ taglib uri="/WEB-INF/tlds/ctl" prefix="ex" %>
<html>
<head>
    <title>Custom Tag Example</title>
</head>
<body>
    <h1>Using Custom Tag</h1>
    <ex:customPrint value="Hello World"/>
</body>
</html>
```

### Explanation

1. *Tag Handler Class*: The `HelloTag` class extends `TagSupport` and overrides the `doStartTag` method to print "Hello, Custom Tag!".
2. *TLD File*: The TLD file defines the custom tag `<hello>` and maps it to the `HelloTag` class.
3. *JSP File*: The JSP file uses the custom tag by declaring the tag library and then using the `<ex:hello />` tag.

This example demonstrates the basics of creating and using custom tag libraries in Java. Custom tags can be much more complex, including attributes and body content processing, but this should give you a solid starting point.
