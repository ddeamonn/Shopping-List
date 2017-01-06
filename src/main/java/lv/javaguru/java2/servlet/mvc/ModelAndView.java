package lv.javaguru.java2.servlet.mvc;

/**
 * Created by DMC on 1/6/2017.
 */
public class ModelAndView {
    private String view;

    private Object data;

    public ModelAndView(Object data, String view) {
        this.data = data;
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public Object getData() {
        return data;
    }

}
