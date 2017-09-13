package com.app.email.interfaces.email.facade.impl;

import com.app.email.interfaces.email.facade.EmailServiceFacade;
import com.app.email.interfaces.email.facade.dto.PasswordDTO;
import com.app.email.utils.ConstantePlantillas;
import java.util.Date;
import java.util.HashMap;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.Map;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class EmailServiceFacadeImpl implements EmailServiceFacade {

    private static final String CHARSET_UTF8 = "UTF-8";
    private final JavaMailSender javaMailSender;

    @Autowired
    VelocityEngine velocityEngine;

    @Autowired
    public EmailServiceFacadeImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void sendEmailResetPassword(PasswordDTO passwordDTO) throws MailException, InterruptedException {
        Thread.sleep(200);
        MimeMessagePreparator preparator;
        preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(passwordDTO.getEmail().toLowerCase());
                message.setFrom(new InternetAddress("jhonmurillo2014@gmail.com"));
                message.setSubject("Cambio De Contraseña");
                message.setSentDate(new Date());
                Map model = new HashMap<>();
                model.put("NOMBRECOMPLETO", passwordDTO.getNombreCompleto());
                model.put("PASSWORD", passwordDTO.getPassword());
                String mensaje = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, ConstantePlantillas.CAMBIO_CONTRASENHA, CHARSET_UTF8, model);
                message.setText(mensaje, true);

            }
        };
        javaMailSender.send(preparator);
        System.out.println("Email Sent!");
    }

    @Override
    @Async
    public void sendEmailRegistry(PasswordDTO passwordDTO) throws MailException, InterruptedException {
        Thread.sleep(200);
        MimeMessagePreparator preparator;
        preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(passwordDTO.getEmail().toLowerCase());
                message.setFrom(new InternetAddress("jhonmurillo2014@gmail.com"));
                message.setSubject("Bienvenido A CLIMA-APP");
                message.setSentDate(new Date());
                Map model = new HashMap<>();
                model.put("NOMBRECOMPLETO", passwordDTO.getNombreCompleto());
                String mensaje = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, ConstantePlantillas.REGISTRO, CHARSET_UTF8, model);
                message.setText(mensaje, true);

            }
        };
        javaMailSender.send(preparator);
        System.out.println("Email Sent!");
    }

//    @Override
//    
//    public void sendEmail(EstudianteAdmitidoMailDTO estudianteAdmitidoMailDTO) throws MailException, InterruptedException {
//        Thread.sleep(200);
//        MimeMessagePreparator preparator;
//        preparator = new MimeMessagePreparator() {
//            @Override
//            public void prepare(MimeMessage mimeMessage) throws Exception {
//                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//                message.setTo(estudianteAdmitidoMailDTO.getEmail());
//                message.setFrom(new InternetAddress("notificaciones@zabud.co"));
//                message.setSubject("Admision de estudiante");
//                message.setSentDate(new Date());
//                Map model = new HashMap<>();
//                model.put("NOMBRE", estudianteAdmitidoMailDTO.getNombreEstudiante());
//                model.put("APELLIDO", estudianteAdmitidoMailDTO.getApellidoEstudiante());
//                model.put("EMAIL", estudianteAdmitidoMailDTO.getEmail());
//                model.put("CODIGO", estudianteAdmitidoMailDTO.getCodigo());
//                model.put("ESTADO", estudianteAdmitidoMailDTO.getEstadoEstudiante());
//                model.put("TIPO_IDENTIFICAION", estudianteAdmitidoMailDTO.getTipoIdentificacion());
//                model.put("IDENTIFICAION", estudianteAdmitidoMailDTO.getIdentificacionEstudiante());
//                model.put("SEMESTRE", estudianteAdmitidoMailDTO.getSemestre().toString());
//                model.put("NIVEL_FORMACION", estudianteAdmitidoMailDTO.getNivelFormacion());
//                model.put("PROGRAMA", estudianteAdmitidoMailDTO.getPrograma());
//                model.put("TIPO_CONVENIO", estudianteAdmitidoMailDTO.getTipoConvenio());
//                model.put("JORNADA", estudianteAdmitidoMailDTO.getModalidad());
//                model.put("PERIODO_ACADEMICO", estudianteAdmitidoMailDTO.getPeriodoacademico());
//                model.put("HORARIO", estudianteAdmitidoMailDTO.getHorario());
//                    String mensaje = VelocityEngineUtils.mergeTemplateIntoString(
//                            velocityEngine, "adminisionEstudiante.vm", CHARSET_UTF8, model);
//                    message.setText(mensaje, true);
//
//            }
//        };
//        javaMailSender.send(preparator);
//        System.out.println("Email Sent!");
//    }
//    
//    @Override
//    @Async
//    public void sendEmailCarteraVencida(CarteraDTO carteraDTO) throws MailException, InterruptedException {
//        Thread.sleep(200);
//        MimeMessagePreparator preparator;
//        preparator = new MimeMessagePreparator() {
//            @Override
//            public void prepare(MimeMessage mimeMessage) throws Exception {
//                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//                messageHelper.setTo(carteraDTO.getEmail());
//                messageHelper.setFrom(new InternetAddress("notificaciones@zabud.co"));
//                messageHelper.setSubject("Notificación cartera vencida");
//                messageHelper.setSentDate(new Date());
//                
//                Map modelCarteraVencida = new HashMap<>();
//                modelCarteraVencida.put("REFERENCIA_CARTERA", carteraDTO.getNumeroReferencia());
//                modelCarteraVencida.put("FECHA_PAGO", carteraDTO.getFechaVencimiento());
//
//                String mensajeCarteraVencida = VelocityEngineUtils.mergeTemplateIntoString(
//                        velocityEngine, "carteraEstudianteVencida.vm", CHARSET_UTF8, modelCarteraVencida);
//                messageHelper.setText(mensajeCarteraVencida, true);
//
//            }
//        };
//        javaMailSender.send(preparator);
//        System.out.println("Email Sent!");
//    }
//
//    @Override
//    @Async
//    public void sendEmailMasivo(List<Usuario> correos) throws MailException, InterruptedException {
//        Thread.sleep(200);
//        for (Usuario user : correos) {
//            MimeMessagePreparator preparator;
//            preparator = new MimeMessagePreparator() {
//                @Override
//                public void prepare(MimeMessage mimeMessage) throws Exception {
//                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//                    message.setTo(user.email());
//                    message.setFrom(new InternetAddress("zabud-yiin@gmail.com"));
//                    message.setSubject("Bienvenidad");
//                    message.setSentDate(new Date());
//                    VelocityEngine ve = new VelocityEngine();
//                    ve.init();
//                    Template template = null;
//                    try {
//                        template = ve.getTemplate("src\\main\\resources\\templates\\admitido.vm");
//                    } catch (ResourceNotFoundException rnfe) {
//                        rnfe.printStackTrace();
//                    } catch (ParseErrorException pee) {
//                        pee.printStackTrace();
//                    } catch (MethodInvocationException mie) {
//                        mie.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    VelocityContext model = new VelocityContext();
//                    model.put("NOMBRE", user.nombre());
//                    model.put("APELLIDO", user.apellido());
//                    model.put("EMAIL", user.email());
//                    StringWriter writer = new StringWriter();
//                    template.merge(model, writer);
//                    message.setText(writer.toString(), true);
//                }
//            };
//            javaMailSender.send(preparator);
//        }
//    }
}
