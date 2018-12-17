<%-- 
    Document   : pergunta
    Created on : 16/12/2018, 21:09:32
    Author     : gabrielk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tela de Login :: Cadastro</h1>
        
        <form action="/cadastrar" method="POST">
            <div>
                <label>Nome</label>
                <input type="text" name="nome"/>
            </div>

            <div>
                <label>senha</label>
                <input type="text" name="senha"/>
            </div>
            
            <button type="submit">Cadastrar</button>
            
        </form>
    </body>
    
    <script>
    
        var err = <%= request.getAttribute("erroNoCadastro")%>
        
        if(err){
            alert("Ocorreu erro")
        }else{
            alert("Cadastrado com sucesso!")
        }
    
    </script>
</html>
