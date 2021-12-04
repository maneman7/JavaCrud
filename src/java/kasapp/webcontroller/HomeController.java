/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.webcontroller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasapp.dao.KasDAO;
import kasapp.dao.KasDAOProses;
import kasapp.model.Kas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author emanu
 */
public class HomeController {
    KasDAO kasDao=null;
    public HomeController(){
        kasDao=new KasDAOProses();
    }
    @RequestMapping(value="/home")
    public ModelAndView home(HttpServletRequest req,HttpServletResponse res) throws SQLException{
//        Connection connection=null;
//        connection=DatabaseConfig.openConnection();
//        if(connection!=null){
//            ModelAndView modelandview=new ModelAndView();
//            modelandview.addObject("msg","Koneksi DB Sukses");
//            return modelandview;
//        }else{
//            ModelAndView modelandview=new ModelAndView();
//            modelandview.addObject("msg","Koneksi DB Gagal");
//            return modelandview;
//        }

        return listKas(req,res);
    }

    private ModelAndView listKas(HttpServletRequest req, HttpServletResponse res) {
        List<Kas> list=kasDao.get();
        ModelAndView modelandview=new ModelAndView();
        modelandview.addObject("listKas", list);
        return modelandview;
    }
}
