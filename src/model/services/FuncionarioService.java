package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.entities.Funcionario;

public class FuncionarioService {

	public void saveOrUpdate(Funcionario obj) {
		
		String caminhoArquivo, caminhoArquivobase, htmlP1, htmlP2, nome, email, area, htmlPronto;
	   
	    nome = obj.getName();
	    caminhoArquivobase = nome + ".htm";
	    caminhoArquivo = "\\\\10.0.253.1\\Grupo.Tecnologia\\assinaturas.htm\\"+caminhoArquivobase;
	    email = obj.getEmail();
	    area = obj.getArea();
	    htmlP1 = "<html xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\" xmlns=\"http://www.w3.org/TR/REC-html40\">\n" +
	"\n" +
	"<head>\n" +
	"    <meta charset=\"UTF-8\">\n" +
	"    <meta http-equiv=Content-Type content=\"text/html; charset=windows-1252\">\n" +
	"    <meta http-equiv=Content-Type content=\"text/html; charset=utf-8″\">\n" +
	"    <meta name=ProgId content=Word.Document>\n" +
	"    <meta name=Generator content=\"Microsoft Word 15\">\n" +
	"    <meta name=Originator content=\"Microsoft Word 15\">\n" +
	"    <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>\n" +
	"\n" +
	"\n" +
	"    <link rel=File-List href=\"index_arquivos/filelist.xml\">\n" +
	"    <link rel=themeData href=\"index_arquivos/themedata.thmx\">\n" +
	"    <link rel=colorSchemeMapping href=\"index_arquivos/colorschememapping.xml\">\n" +
	"\n" +
	"\n" +
	"</head>\n" +
	"\n" +
	"\n" +
	"\n" +
	"<body lang=EN-US>\n" +
	"    <p>Atenciosamente,</p>\n" +
	"\n" +
	"    <div>\n" +
	"        <table>\n" +
	"\n" +
	"            <tbody style=\"font-family:tahoma,arial,verdana; font-size:10px; padding-left:10px;\">\n" +
	"\n" +
	"                <tr>\n" +
	"                    <td>\n" +
	"                        <hr size=\"7 \" color=\" #FFBC00 \" />\n" +
	"                        <table cellspacing=\"1\" cellpadding=\"1\">\n" +
	"\n" +
	"                            <!-- ADD IMAGEM -->\n" +
	"                            <tbody>\n" +
	"                                <tr>\n" +
	"                                    <td>\n" +
	"                                        <table cellspacing=\"1\" cellpadding=\"0\">\n" +
	"                                            <tbody>\n" +
	"                                                <tr>\n" +
	"                                                    <td>\n" +
	"\n" +
	"                                                        <p style=\"margin: 0px 0px 5px 0px; padding-left: 10px; padding-bottom: 10px; align-items: center;\">\n" +
	"                                                            <a href=\"http://hbraviacao.com.br/\"><img src=\"https://testehbr.s3.sa-east-1.amazonaws.com/HBRlogos/logohbr180px.png\" alt=\"LOGO HBR\"></a>\n" +
	"\n" +
	"                                                            </a>\n" +
	"                                                        </p>\n" +
	"\n" +
	"\n" +
	"                                                    </td>\n" +
	"\n" +
	"                                                    <td valign=\"top\">\n" +
	"\n" +
	"                                                </tr>\n" +
	"                                            </tbody>\n" +
	"                                        </table>\n" +
	"                                        <!-- //ADD IMAGEM -->\n" +
	"\n" +
	"                                        <td style=\"width: 5px; border-right-width: 3px; border-right-style: solid ; border-right-color: #b1a9a9 ; height: 1px; font-size:1pt;\"> </td>\n" +
	"                                        </td>\n" +
	"                                        <td width=\"0\" height=\"1\"> </td>\n" +
	"                                        <td valign=\"top\">\n" +
	"\n" +
	"                                            <!-- ADD CONTEÚDO -->\n" +
	"                                            <table cellspacing=\"0\" cellpadding=\"5\">\n" +
	"                                                <tbody>\n" +
	"                                                    <tr>\n" +
	"                                                        <td><span><span style=\"font-weight: bold; font-size: 25px;\" >"+nome+"                                                                                                                       </span><br />\n" +
	"                                                            <span style=\"font-weight: bold; font-size: 18px;\"> "+area+"| HBR Aviação</span></td>\n" +
	"                                                    </tr>\n" +
	"                                                    <td>\n" +
	"                                                        <p style=\"font-weight: bold;\"> (11) 4880-0000 <br>\n" +
	"                                                            <a href=\"mailto:"+email+"\" style=\"padding-top: 0px;text-decoration: none; font-weight: bold;\">"+email+"</a>\n" +
	"                                                        </p>\n" +
	"                                                        <p style=\"margin: auto; \">Av. Dr. Mauro Lindemberg Monteiro, 979<br /> CEP 06278-010   Osasco-SP   Brasil</p>\n" +
	"                                                        <p>\n" +
	"                                                            <a href=\"https://pt-br.facebook.com/hbraviacao/ \" target=\"_blank \"><img src=\"https://s3.amazonaws.com/htmlsig-assets/round/facebook.png \" alt=\"Facebook \" width=\"25 \" height=\"25 \" data-filename=\"facebook.png\n" +
	"                  \" /></a> <img src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif \" width=\"2 \" /> \n" +
	"                                                            <a href=\"https://www.instagram.com/hbraviacao/ \" target=\"_blank \"><img src=\"https://s3.amazonaws.com/htmlsig-assets/round/instagram.png\" alt=\"Instagram \" width=\"25 \" height=\"25\n" +
	"                  \" data-filename=\"instagram.png \" /></a> <img src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif \" width=\"2 \" /> \n" +
	"                                                            <a href=\"https://www.linkedin.com/company/hbraviacao/mycompany/ \" target=\"_blank \"><img src=\"https://s3.amazonaws.com/htmlsig-assets/round/linkedin.png \" alt=\"LinkedIn \" width=\"25 \" height=\"25 \" data-filename=\"linkedin.png\n" +
	"                  \" /></a> <img src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif \" width=\"2 \" /> \n" +
	"                                                            <a href=\"https://www.google.com/search?q=hbr%20aviacao&rlz=1C1FCXM_pt-PTBR974BR974&oq=hbr+aviacao+&aqs=chrome..69i57j0i512j0i22i30l3j69i60l3.1813j0j4&sourceid=chrome&ie=UTF-8&tbs=lrf:!1m4!1u2!2m2!2m1!1e1!2m1!1e2!3sIAE,lf:1,lf_ui:2&tbm=lcl&sxsrf=AOaemvLSi7H9z4C_J2zHmnuXorakUTabXA:1633985730750&rflfq=1&num=10&rldimm=6822068741981745120&lqi=CgtoYnIgYXZpYWNhb0i03Pzq7qqAgAhaFRAAEAEYABgBIgtoYnIgYXZpYWNhb5IBEGNvcnBvcmF0ZV9vZmZpY2U&ved=2ahUKEwjk3bGYn8PzAhW_rZUCHUtUBKUQvS56BAgZECE&rlst=f#rlfi=hd:;si:6822068741981745120,l,CgtoYnIgYXZpYWNhb0i03Pzq7qqAgAhaFRAAEAEYABgBIgtoYnIgYXZpYWNhb5IBEGNvcnBvcmF0ZV9vZmZpY2U;mv:[[-23.476780299999998,-46.7795785],[-23.4778046,-46.7821527]];tbs:lrf:!1m4!1u2!2m2!2m1!1e1!2m1!1e2!3sIAE,lf:1,lf_ui:2 \"\n" +
	"                                                                target=\"_blank \"><img src=\"https://s3.amazonaws.com/htmlsig-assets/round/maps.png \" alt=\"Maps \" width=\"25 \" height=\"25 \" data-filename=\"maps.png \" /></a> <img src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\n" +
	"                  \" width=\"2 \" /> \n" +
	"                                                        </p>\n" +
	"                                                    </td>\n" +
	"\n" +
	"\n" +
	"                                                </tbody>\n" +
	"\n" +
	"                                            </table>\n" +
	"\n" +
	"\n" +
	"                                            <p class=MsoAutoSig>\n" +
	"                                                <o:p> </o:p>\n" +
	"                                            </p>\n" +
	"                                        </td>\n" +
	"\n" +
	"                        </table>\n" +
	"                        <!-- //ADD CONTEÚDO  -->\n" +
	"\n" +
	"                        <hr size=\"7 \" color=\" #FFBC00 \" />\n" +
	"\n" +
	"\n" +
	"                        <!-- AVISO LEGAL -->\n" +
	"                        <div style=\"position: fixed; font-size: 10px;\">\n" +
	"\n" +
	"                            <p>\n" +
	"                                AVISO LEGAL: Esta mensagem, incluindo seus anexos, é destinada exclusivamente para a(s) pessoa(s) a quem <br> é dirigida, podendo conter informação confidencial e/ou privilegiada. <br> Se você não for destinatário desta\n" +
	"                                mensagem, desde já fica notificado de abster-se de utilizar a informação contida <br> nesta mensagem de qualquer forma, sujeitando o infrator às penas da lei; notificar o remetente e eliminar o seu <br> conteúdo de forma\n" +
	"                                definitiva. Informações transmitidas por e-mail podem ser alteradas por terceiros, <br> não havendo garantia de que sua integridade foi mantida e que esteja livre de vírus, interceptação ou interferência, <br> não podendo\n" +
	"                                ser imputada qualquer responsabilidade à HBR Aviação com relação ao seu conteúdo;\n" +
	"\n" +
	"                            </p>\n" ;
	    
	htmlP2 = "<p>\n" +
	"                                LEGAL NOTICE: This message, including its attachments, is intended exclusively for the people to whom it is addressed, <br> and may contain confidential and/or privileged information. If you are not a recipient of this\n" +
	"                                message, <br> you are hereby notified to refrain from using the information contained in this message, subjecting <br> the infringer to the penalties of the law. Information transmitted by e-mail may be changed by third\n" +
	"                                parties, <br> and there is no guarantee that its integrity has been maintained and that it is free of viruses, <br> interception or interference, and no responsibility will be attributed to HBR Aviation in relation to its\n" +
	"                                content;\n" +
	"\n" +
	"                            </p>\n" +
	"                        </div>\n" +
	"                        <!-- //AVISO LEGAL -->\n" +
	"\n" +
	"\n" +
	"                        </tr>\n" +
	"\n" +
	"\n" +
	"                </tr>\n" +
	"\n" +
	"                </tbody>\n" +
	"\n" +
	"        </table>\n" +
	"    </div>\n" +
	"\n" +
	"</body>\n" +
	"\n" +
	"\n" +
	"</html>";
	    
	htmlPronto = htmlP1 + htmlP2;  
	escreverTexto(caminhoArquivo, htmlPronto);            
	}
	
	public static void escreverTexto(String caminhoArquivo, String htmlPronto){
        
        try {   
            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivo, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
            PrintWriter escritordeArquivos = new PrintWriter(buffer);
			escritordeArquivos.append(htmlPronto);                    
        } catch(IOException e) {
            e.printStackTrace();
        }
	}
}
