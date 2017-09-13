package com.app.email.interfaces.email.facade.web;

import com.app.email.interfaces.email.facade.EmailServiceFacade;
import com.app.email.interfaces.email.facade.dto.EmailDTO;
import com.app.email.interfaces.email.facade.dto.PasswordDTO;
import com.app.email.utils.ConstanteUtil;
import com.app.email.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RequestMapping("/Email")
@Api(value = "Auth RestController", description = "This API has a Methods of Auth")
public class EmailResource {

    @Autowired
    private EmailServiceFacade emailServiceFacade;

    private final Logger logger = LoggerFactory.getLogger(EmailResource.class);

    @RequestMapping(value = "hello")
    @ApiOperation(value = "hello", notes = "Return String")
    public String enviarCorreo() {
        return "Hola Jhon";
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    @ApiOperation(value = "password", notes = "Return ResponseUtil")
    public ResponseUtil enviarCorreoCarteraVencida(@RequestBody @Valid PasswordDTO passwordDTO) throws InterruptedException {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            emailServiceFacade.sendEmailRegistry(passwordDTO);
            responseUtil = new ResponseUtil("Gracias por comunicarte con nosotros", ConstanteUtil.CODE_OK);
        } catch (MailException e) {
            responseUtil = new ResponseUtil("Error Sending Email: " + e.getMessage(), ConstanteUtil.CODE_ERROR);
        }

        return responseUtil;
    }

    @RequestMapping(value = "mail", method = RequestMethod.POST)
    @ApiOperation(value = "mail", notes = "Return ResponseUtil")
    public ResponseUtil enviarMail(@RequestBody @Valid EmailDTO emailDTO) throws InterruptedException {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            emailServiceFacade.sendEmail(emailDTO);
            responseUtil = new ResponseUtil("Gracias por comunicarte con nosotros", ConstanteUtil.CODE_OK);
        } catch (MailException e) {
            responseUtil = new ResponseUtil("Error Sending Email: " + e.getMessage(), ConstanteUtil.CODE_ERROR);
        }

        return responseUtil;
    }
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
