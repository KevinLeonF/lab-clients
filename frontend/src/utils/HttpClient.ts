export interface HttpClient {
  get<T>(url: string): Promise<T>;
  post<T, U>(url: string, data: U): Promise<T>;
}

export class FetchHttpClient implements HttpClient {
  private readonly baseUrl: string;
  constructor(baseUrl: string = "http://localhost:8080/api") {
    this.baseUrl = baseUrl;
  }
  async get<T>(url: string): Promise<T> {
    try {
      const response = await fetch(this.baseUrl + url);
      if (!response.ok) {
        throw new Error(`HTTP ${response.status}: ${response.statusText}`);
      }
      return response.json();
    } catch (err) {
      if (err instanceof TypeError) {
        throw new Error(`No se puede conectar a ${this.baseUrl}. ¿Backend está corriendo?`);
      }
      throw err;
    }
  }
  async post<T, U>(url: string, data: U): Promise<T> {
    try {
      const response = await fetch(this.baseUrl + url, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      });
      if (!response.ok) {
        throw new Error(`HTTP ${response.status}: ${response.statusText}`);
      }
      return response.json();
    } catch (err) {
      if (err instanceof TypeError) {
        throw new Error(`No se puede conectar a ${this.baseUrl}. ¿Backend está corriendo?`);
      }
      throw err;
    }
  }
}