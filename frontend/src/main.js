import "./style.css";
import { FetchHttpClient } from "./utils/HttpClient.ts";
import { Clients } from "./modules/clients/clients.ts";

const httpClient = new FetchHttpClient();
const clientsModule = new Clients(httpClient);

const form = document.getElementById("form");
const list = document.getElementById("list");

async function getAllClients() {
  try {
    const clients = await clientsModule.getClients();
    list.innerHTML = clients
      .map(
        (c) => `
      <div>
        <b>${c.name}</b> (${c.email}) - ${c.phone || ""}
      </div>
    `
      )
      .join("");
  } catch (err) {
    list.innerHTML = `<p>Error cargando clientes: ${err.message}</p>`;
    console.error(err);
  }
}

form.addEventListener("submit", async (e) => {
  e.preventDefault();
  
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const phone = document.getElementById("phone").value.trim();

  if (!name || !email) {
    alert("Name and email required");
    return;
  }

  try {
    await clientsModule.saveClient({ name, email, phone });
    form.reset();
    getAllClients();
  } catch (err) {
    console.error(err);
    alert("Error al crear cliente: " + err.message);
  }
});

getAllClients();