package com.pitore.backendpitore.service.impl;

import com.pitore.backendpitore.model.DetallePregunta;
import com.pitore.backendpitore.model.Iteracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.DetallePreguntaRepository;
import com.pitore.backendpitore.repository.IteracionRepository;
import com.pitore.backendpitore.service.IteracionService;

import java.util.List;
import java.util.Optional;
@Service
public class IteracionServiceImpl implements IteracionService {
	double nominador;
    double denominador;
    double idoneidad;
    double usabilidad;
    double rendimiento;

    @Autowired
    private IteracionRepository iteracionRepository;
    @Autowired
    private DetallePreguntaRepository detallePreguntaRepository;

    @Override
    public JpaRepository<Iteracion, Integer> getRepository() {
        return iteracionRepository;
    }

    @Override
    public List<Iteracion> getAll() throws Exception {

        List<Iteracion> iteraciones = IteracionService.super.getAll();    
        return this.LoadIteraciones(iteraciones);
    }

    public List<Iteracion> LoadIteraciones(List<Iteracion> iteraciones) throws Exception {

        for (var iteracion:iteraciones) {        
            List<DetallePregunta> detallePreguntas = detallePreguntaRepository.ListarPorIdIteracion(iteracion.getcIteracion());

            if (!detallePreguntas.isEmpty()){
                nominador= 0.0;
                denominador=0.0;
                idoneidad=0.0;
                usabilidad=0.0;
                rendimiento=0.0;
          for (int i=0;i<6;i++){
              System.out.println("nominador-inicial:" +nominador);
              denominador += detallePreguntas.get(i).gettRespuestaPregunta();
                               }
                System.out.println("nominador:" +nominador);
          for (int i=6;i<12;i++){
              nominador += detallePreguntas.get(i).gettRespuestaPregunta();
                                }

          if (this.denominador!=0) idoneidad=(nominador/denominador)*100;
          else idoneidad=0;
                System.out.println("denominador:" +denominador);
                for (int i=12;i<30;i++){
                    usabilidad += (detallePreguntas.get(i).gettRespuestaPregunta()/(18*7))*100;
                }
          rendimiento=detallePreguntas.get(30).gettRespuestaPregunta()*100;
                iteracion.setIdoneidad(idoneidad);
                iteracion.setUsabilidad(usabilidad);
                iteracion.setRendimiento(rendimiento);
          System.out.println("IDONEIDAD:" +idoneidad);
                System.out.println("USABILIDAD:" +usabilidad);
                System.out.println("RENDIMIENTO:" +rendimiento);
          iteracion.setpCalidad((idoneidad+usabilidad+rendimiento)/3);

          if (iteracion.getpCalidad()<25) iteracion.settNivel(1);
          else if (iteracion.getpCalidad()>=25&&iteracion.getpCalidad()<50) iteracion.settNivel(2);
          else if (iteracion.getpCalidad()>=50&&iteracion.getpCalidad()<70) iteracion.settNivel(3);
          else if (iteracion.getpCalidad()>=70&&iteracion.getpCalidad()<90) iteracion.settNivel(4);
          else iteracion.settNivel(5);
          
            }
        }
        return iteraciones;
    }
    
    
    @Override
    public Optional<Iteracion> findById(Integer integer) throws Exception {
        return IteracionService.super.findById(integer);
    }

    @Override
    public Iteracion create(Iteracion entity) throws Exception {
        return IteracionService.super.create(entity);
    }

    @Override
    public Iteracion update(Iteracion entity) throws Exception {
        return IteracionService.super.update(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        IteracionService.super.deleteById(integer);
    }

    @Override
    public Integer isIteracionRespondida(int idIteracion) {
        return iteracionRepository.isIteracionRespondida(idIteracion);
    }

    @Override
    public List<Iteracion> getIteracionByC_grupo(int c_grupo) throws Exception{
        List<Iteracion> iteraciones = iteracionRepository.getIteracionByC_grupo(c_grupo);
         return this.LoadIteraciones(iteraciones);
    }
}
