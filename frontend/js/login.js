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
        const resposta = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: email,
                senha: senha
            })
        });

        if (resposta.ok) {
            const dados = await resposta.json();

            // Guarda o JWT
            localStorage.setItem("token", dados.token);

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