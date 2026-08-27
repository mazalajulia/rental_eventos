const loginForm = document.getElementById("loginForm");
const mensagem = document.getElementById("mensagem");

loginForm.addEventListener("submit", async function(event) {

    event.preventDefault();

    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value;


    if (!email || !senha) {

        mensagem.textContent = "Preencha o e-mail e a senha.";
        mensagem.style.color = "red";

        return;
    }


    try {

        const resposta = await fetch(
            `http://localhost:8080/usuarios/login?email=${encodeURIComponent(email)}&senha=${encodeURIComponent(senha)}`,
            {
                method: "POST"
            }
        );


        if (resposta.ok) {

            const usuario = await resposta.json();

            // Guarda os dados do usuário para usar nas outras páginas
            localStorage.setItem("usuario", JSON.stringify(usuario));

            mensagem.textContent = "Login realizado com sucesso!";
            mensagem.style.color = "green";


            // Vai para a Home
            setTimeout(function() {

                window.location.href = "inicio.html";

            }, 500);

        } else if (resposta.status === 401) {

            mensagem.textContent = "E-mail ou senha incorretos.";
            mensagem.style.color = "red";

        } else {

            mensagem.textContent = "Erro ao realizar login.";
            mensagem.style.color = "red";

        }

    } catch (erro) {

        console.error(erro);

        mensagem.textContent =
            "Não foi possível conectar ao servidor.";

        mensagem.style.color = "red";

    }

});