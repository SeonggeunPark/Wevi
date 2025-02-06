import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:3000",
  headers: {
    "Content-Type": "application/json",
  },
  withCredentials: true,
});

export async function handleLogin(email, password) {
  try {
    // const response = await api.post(`/login`, { email, password });
    // return response.data;
    if (email === "ss@s" && password === "123") {
      const user = {
        default: "ss@s",
      };
      return user;
    } else {
      throw new Error("로그인 실패");
    }
  } catch (error) {
    throw new Error("로그인 실패");
  }
}
