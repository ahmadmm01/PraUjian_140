/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.praujian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ws.a.praujian.exceptions.NonexistentEntityException;

/**
 *
 * @author MADD
 */
@Controller
@ResponseBody
public class myController
{
    Barang data = new Barang();
    BarangJpaController jpactrl = new BarangJpaController();
    
    @RequestMapping("/getBarang/{id}")
    public String getBarang(@PathVariable("id") int id)
    {
        try
        {
            data = jpactrl.findBarang(id);
            return data.getNama()+"<br>"+ data.getJumlah();
        }
        catch (Exception error)
        {
            return "Data tidak ditemukan.";
        }
    }
    
    @RequestMapping("/getBarangAll")
    public List<Barang> getAll()
    {
        return jpactrl.findBarangEntities();
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") int id)
    {
        try
        {
            jpactrl.destroy(id);
            return id + " Deleted.";
        }
        catch (NonexistentEntityException error)
        {
            return id + " Data tidak ditemukan.";
        }
    }
    
    
}