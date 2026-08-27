const cadastroForm = document.getElementById("cadastroForm");
const mensagem = document.getElementById("mensagem");

cadastroForm.addEventListener("submit", async function(event) {

    event.preventDefault();

    const nome = document.getElementById("nome").value.trim();
    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value;
    const confirmarSenha = document.getElementById("confirmarSenha").value;


    // Verifica se as senhas são iguais

    if (senha !== confirmarSenha) {

        mensagem.textContent = "As senhas não são iguais.";
        mensagem.style.color = "red";

        return;
    }


    // Dados que serão enviados para o backend

    const usuario = {
        nome: nome,
        email: email,
        senha: senha
    };


    try {

        const resposta = await fetch("http://localhost:8080/usuarios", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(usuario)

        });


        if (resposta.ok) {

            mensagem.textContent = "Cadastro realizado com sucesso!";
            mensagem.style.color = "green";

            cadastroForm.reset();


            // Depois de 1 segundo, volta para o login

            setTimeout(function() {

                window.location.href = "index.html";

            }, 1000);

        } else {

            mensagem.textContent = "Não foi possível realizar o cadastro.";
            mensagem.style.color = "red";

        }

    } catch (erro) {

        console.error(erro);

        mensagem.textContent =
            "Erro ao conectar com o servidor.";

        mensagem.style.color = "red";

    }

});