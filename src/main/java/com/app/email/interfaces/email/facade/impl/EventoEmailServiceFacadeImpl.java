package com.app.email.interfaces.email.facade.impl;

import com.app.email.interfaces.email.facade.EmailServiceFacadeEvento;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class EventoEmailServiceFacadeImpl implements EmailServiceFacadeEvento {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventoEmailServiceFacadeImpl.class.getName());
    private static final String CHARSET_UTF8 = "UTF-8";
    private final JavaMailSender javaMailSender;

//    @Autowired
//    VelocityEngine velocityEngine;

    @Autowired
    public EventoEmailServiceFacadeImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

//    @Override
//    @Async
//    public void sendEmailAdmitido(EstudianteAdmitidoMailDTO estudianteAdmitidoMailDTO) throws MailException, InterruptedException {
//        Thread.sleep(100);
//        MimeMessagePreparator preparator;
//        preparator = (MimeMessage mimeMessage) -> {
//            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//            message.setTo(estudianteAdmitidoMailDTO.getEmail());
//            message.setFrom(new InternetAddress(ConstanteUtil.CORREO_NOTIFICACON));
//            message.setSubject(ConstanteUtil.ASUNTO_ADMISION);
//            message.setSentDate(new Date());
//            message.setText(armarMensaje(ConstantePlantillas.ADMISION_ESTUDIANTE, crearNotificacionAdmitido(estudianteAdmitidoMailDTO)), true);
//        };
//        javaMailSender.send(preparator);
//        LOGGER.info("Email enviado ADMITIDO!");
//    }
//
//    @Override
//    @Async
//    public void sendEmailAdmitidoMasivo(List<EstudianteAdmitidoMailDTO> estudianteAdmitidoMailDTOs) throws MailException, InterruptedException {
//        Thread.sleep(100);
//        for (EstudianteAdmitidoMailDTO estudianteAdmitidoMailDTO : estudianteAdmitidoMailDTOs) {
//            MimeMessagePreparator preparator;
//            preparator = (MimeMessage mimeMessage) -> {
//                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//                message.setTo(estudianteAdmitidoMailDTO.getEmail());
//                message.setFrom(new InternetAddress(ConstanteUtil.CORREO_NOTIFICACON));
//                message.setSubject(ConstanteUtil.ASUNTO_ADMISION);
//                message.setSentDate(new Date());
//                message.setText(armarMensaje(ConstantePlantillas.ADMISION_ESTUDIANTE, crearNotificacionAdmitido(estudianteAdmitidoMailDTO)), true);
//            };
//            javaMailSender.send(preparator);
//            LOGGER.info("Email enviado ADMITIDO!");
//        }
//    }
//
//    @Override
//    @Async
//    public void sendNotificacionCartera(CarteraDTO carteraDTO) throws MailException, InterruptedException {
//        Thread.sleep(100);
//        MimeMessagePreparator preparator;
//        preparator = (MimeMessage mimeMessage) -> {
//            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//            message.setTo(carteraDTO.getEmail());
//            message.setFrom(new InternetAddress(ConstanteUtil.CORREO_NOTIFICACON));
//            message.setSentDate(new Date());
//            message.setSubject(asuntoCorreoCartera(carteraDTO));
//            message.setText(armarMensaje(templateNotificacicoCartera(carteraDTO), crearNotificacionCartera(carteraDTO)), true);
//        };
//        javaMailSender.send(preparator);
//        LOGGER.info("Email enviado a cartera unico!");
//    }
//
//    private String armarMensaje(String template, Map model) {
//        String mensaje = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, CHARSET_UTF8, model);
//        return mensaje;
//    }
//
//    @Override
//    @Async
//    public void sendNotificacionCarteraMasivo(List<CarteraDTO> carterasDTO) throws MailException, InterruptedException {
//        Thread.sleep(100);
//        for (CarteraDTO carteraDTO : carterasDTO) {
//            MimeMessagePreparator preparator;
//            preparator = (MimeMessage mimeMessage) -> {
//                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//                message.setTo(carteraDTO.getEmail());
//                message.setFrom(new InternetAddress(ConstanteUtil.CORREO_NOTIFICACON));
//                message.setSentDate(new Date());
//                message.setSubject(asuntoCorreoCartera(carteraDTO));
//                message.setText(armarMensaje(templateNotificacicoCartera(carteraDTO), crearNotificacionCartera(carteraDTO)), true);
//            };
//            javaMailSender.send(preparator);
//            LOGGER.info("Email enviado a cartera! masivo");
//        }
//    }
//
//    private Map crearNotificacionAdmitido(EstudianteAdmitidoMailDTO estudianteAdmitidoMailDTO) {
//        Map model = new HashMap<>();
//        //campos de la plantilla para admisión
//        model.put("NOMBRE", estudianteAdmitidoMailDTO.getNombreEstudiante());
//        model.put("APELLIDO", estudianteAdmitidoMailDTO.getApellidoEstudiante());
//        model.put("EMAIL", estudianteAdmitidoMailDTO.getEmail());
//        model.put("CODIGO", estudianteAdmitidoMailDTO.getCodigo());
//        model.put("ESTADO", estudianteAdmitidoMailDTO.getEstadoEstudiante());
//        model.put("TIPO_IDENTIFICAION", estudianteAdmitidoMailDTO.getTipoIdentificacion());
//        model.put("IDENTIFICAION", estudianteAdmitidoMailDTO.getIdentificacionEstudiante());
//        model.put("SEMESTRE", estudianteAdmitidoMailDTO.getSemestre().toString());
//        model.put("NIVEL_FORMACION", estudianteAdmitidoMailDTO.getNivelFormacion());
//        model.put("PROGRAMA", estudianteAdmitidoMailDTO.getPrograma());
//        model.put("TIPO_CONVENIO", estudianteAdmitidoMailDTO.getTipoConvenio());
//        model.put("JORNADA", estudianteAdmitidoMailDTO.getModalidad());
//        model.put("PERIODO_ACADEMICO", estudianteAdmitidoMailDTO.getPeriodoacademico());
//        model.put("HORARIO", estudianteAdmitidoMailDTO.getHorario());
//        return model;
//    }
//
//    private Map crearNotificacionCartera(CarteraDTO carteraDTO) {
//        Map model = new HashMap<>();
//        model.put("NOMBRE", carteraDTO.getCliente());
//        model.put("CODIGO", carteraDTO.getCodigoEstudiante());
//        model.put("PERIODO_ACADEMICO", carteraDTO.getPeriodoAcademico());
//        model.put("JORNADA", carteraDTO.getModalidad());
//        model.put("PROGRAMA", carteraDTO.getPrograma());
//        model.put("SEMESTRE", carteraDTO.getSemestre());
//        model.put("ESTADO_CARTERA", carteraDTO.getEstadoCartera());
//        model.put("FECHA_VENCIMIENTO", converFechaLongToString(carteraDTO.getFechaVencimiento().getTimeInMillis()));
//        model.put("NUM_REF", carteraDTO.getNumeroReferencia());
//        model.put("CONCEPTO", carteraDTO.getNombreConcepto());
//        return model;
//
//    }
//
//    private String asuntoCorreoCartera(CarteraDTO carteraDTO) {
//        StringBuilder cartera = new StringBuilder();
//        cartera.append("Notificación cartera ");
//        if (carteraDTO.getEstadoCartera().equals(ConstanteUtil.EstadoCartera.VENCIDA.name())) {
//            cartera.append(carteraDTO.getEstadoCartera().toLowerCase());
//        } else if (carteraDTO.getEstadoCartera().equals(ConstanteUtil.CARTERA_POR_VENCER)) {
//            cartera.append(" próxima a vencer ")/*carteraDTO.getEstadoCartera().toLowerCase()*/;
//        } else if (carteraDTO.getEstadoCartera().equals(ConstanteUtil.EstadoCartera.PAGADA.name())) {
//            cartera.append(carteraDTO.getEstadoCartera().toLowerCase());
//        } else {
//            cartera.append(carteraDTO.getEstadoCartera().toLowerCase());
//        }
//        return cartera.toString();
//    }
//
//    private String templateNotificacicoCartera(CarteraDTO carteraDTO) {
//        String template = null;
//        if (carteraDTO.getEstadoCartera().equals(ConstanteUtil.EstadoCartera.VENCIDA.name())) {
//            template = ConstantePlantillas.CARTERA_VENCIDA;
//        } else if (carteraDTO.getEstadoCartera().equals(ConstanteUtil.CARTERA_POR_VENCER)) {
//            template = ConstantePlantillas.CARTERA_POR_VENCER;
//        } else if (carteraDTO.getEstadoCartera().equals(ConstanteUtil.EstadoCartera.PAGADA.name())) {
//            template = ConstantePlantillas.CARTERA_PAGADA;
//        } else {
//            template = ConstantePlantillas.CARTERA_VIGENTE;
//        }
//        return template;
//    }
//    
//    
//     private String converFechaLongToString(Long fecha) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(fecha);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        sdf.setCalendar(cal);
//        return sdf.format(cal.getTime());
//    }

}
