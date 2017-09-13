package com.app.email.interfaces.email.facade.web;


import com.app.email.interfaces.email.facade.EmailServiceFacade;
import com.app.email.utils.ConstanteUtil;
import com.app.email.utils.ObjectMapperUtil;
import com.app.email.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RequestMapping("/Email")
public class EmailResource {

    @Autowired
    private EmailServiceFacade emailServiceFacade;

    private final Logger logger = LoggerFactory.getLogger(EmailResource.class);

//    @RequestMapping(value = "enviar", method = RequestMethod.POST)
//    public ResponseUtil enviarCorreo(@RequestBody @Valid EstudianteAdmitidoMailDTO estudianteAdmitidoMailDTO) throws InterruptedException {
//        ResponseUtil responseUtil = new ResponseUtil();
////        ObjectMapper mapperObject = ObjectMapperUtil.getInstanceObjectMapper();
////        Usuario usuario = mapperObject.convertValue(usuarioDTO, Usuario.class);
//        try {
//            emailServiceFacade.sendEmail(estudianteAdmitidoMailDTO);
//            responseUtil = new ResponseUtil("Gracias por comunicarte con nosotros", ConstanteUtil.CODE_OK);
//        } catch (MailException e) {
//            responseUtil = new ResponseUtil("Error Sending Email: " + e.getMessage(), ConstanteUtil.CODE_ERROR);
//        }
//
//        return responseUtil;
//    }
//    
//    @RequestMapping(value = "enviarCarteraVencida", method = RequestMethod.POST)
//    public ResponseUtil enviarCorreoCarteraVencida(@RequestBody @Valid CarteraDTO carteraDTO) throws InterruptedException {
//        ResponseUtil responseUtil = new ResponseUtil();
//        try {
//            emailServiceFacade.sendEmailCarteraVencida(carteraDTO);
//            responseUtil = new ResponseUtil("Gracias por comunicarte con nosotros", ConstanteUtil.CODE_OK);
//        } catch (MailException e) {
//            responseUtil = new ResponseUtil("Error Sending Email: " + e.getMessage(), ConstanteUtil.CODE_ERROR);
//        }
//
//        return responseUtil;
//    }
//
//    @RequestMapping(value = "enviarMasivo", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseUtil enviarCorreoMasivo(@RequestBody @Valid List<UsuarioDTO> usuarioDTOs) throws InterruptedException {
//        ObjectMapper mapperObject = ObjectMapperUtil.getInstanceObjectMapper();
//        ResponseUtil responseUtil = new ResponseUtil();
//        List<Usuario> correos = new ArrayList<>();
//        for (UsuarioDTO usuarioDTO : usuarioDTOs) {
//            Usuario usuario = mapperObject.convertValue(usuarioDTO, Usuario.class);
//            correos.add(usuario);
//        }
//        try {
//            emailServiceFacade.sendEmailMasivo(correos);
//            responseUtil = new ResponseUtil("Gracias por comunicarte con nosotros", ConstanteUtil.CODE_OK);
//        } catch (MailException e) {
//            responseUtil = new ResponseUtil("Error Sending Email: " + e.getMessage(), ConstanteUtil.CODE_ERROR);
//        }
//        return responseUtil;
//    }

}
