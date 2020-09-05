package base.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import base.dao.TavaraDao;
import base.model.Tavara;

@Controller
public class SampleController {
	
	@Autowired
	private HelloWorld hello;
	
    public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
	@Autowired
	private TavaraDao tavaraDao;
	
	

	@RequestMapping("/sample2")
    public ModelAndView showForm() {
    	System.out.println("jipii!!");
    	ModelAndView joku = new ModelAndView("sample");
    	joku.getModel().put("nimi", hello.getName());
    	joku.getModel().put("alias", hello.getAlias());
    	List<Tavara> tavarat = tavaraDao.findItems();
    	for(Tavara t : tavarat) {
    		System.out.println(t.getNimi() + " " + t.getKuvaus());
    	}
    	joku.getModel().put("tavarat", tavarat);
    	return joku;
    }
 
}
