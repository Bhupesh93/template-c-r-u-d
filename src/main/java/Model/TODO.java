package Model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sboob on 5/28/2016.
 */
@XmlRootElement
public class TODO {
    public  TODO(){

    }
    public TODO(String text) {
        super();
        this.text = text;
    }

    private  String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
