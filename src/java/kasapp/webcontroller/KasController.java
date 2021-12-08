/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasapp.dao.KasDAO;
import kasapp.dao.KasDAOProses;
import kasapp.model.Kas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author emanu
 */
@Controller
public class KasController {
    KasDAO kasDao=null;
    public KasController(){
        kasDao=new KasDAOProses();
    }
    
    @RequestMapping(value="/kas-form")
    public ModelAndView index(HttpServletRequest req,HttpServletResponse res){
        String action=req.getParameter("action");
        ModelAndView modelandview=new ModelAndView();
        if(action==null){
            action="add";
        }
        switch(action){
            case "edit":
                modelandview=editKas(req,res);
                break;
            case "delete":
                modelandview=deleteKas(req,res);
                break;
            default:
                modelandview=addKas(req,res);
                break;
        }
        
        return modelandview;
    }
    
    @RequestMapping(value="/kas-form",method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("kas") Kas ks){
        ModelAndView modelandview=new ModelAndView("redirect:/kas-form.html");
        if(ks.getId()!=0){
            if(kasDao.update(ks)){
                return new ModelAndView("redirect:/home.html");
            }else{
                modelandview.addObject("message", "Gagal Update data");
            }
        }else{
            if(kasDao.save(ks)){
                return new ModelAndView("redirect:/home.html");
            }else{
                modelandview.addObject("message", "Gagal simpan data");
            }
        }
        return modelandview;
    }

    private ModelAndView editKas(HttpServletRequest req, HttpServletResponse res) {
        String id=req.getParameter("id");
        Kas kas=kasDao.getSinggle(Integer.parseInt(id));
        ModelAndView modelandview=new ModelAndView();
        modelandview.addObject("kas", kas);
        return modelandview;
    }

    private ModelAndView deleteKas(HttpServletRequest req, HttpServletResponse res) {
        String id=req.getParameter("id");
        if(kasDao.delete(Integer.parseInt(id))){
            return new ModelAndView("redirect:/home.html");
        }else{
            req.setAttribute("message", "gagal delete");
            return addKas(req,res);
        }
    }

    private ModelAndView addKas(HttpServletRequest req, HttpServletResponse res) {
        if(req.getParameter("message")!=null){
            ModelAndView modelandview=new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }
}
