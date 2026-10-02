import { apiRequest } from "./api";

export function registerUser(formData) {
  return apiRequest("/api/auth/register", {
    method: "POST",
    body: JSON.stringify(formData),
  });
}

export function loginUser(formData) {
  return apiRequest("/api/auth/login", {
    method: "POST",
    body: JSON.stringify(formData),
  });
}

export function getCurrentUser() {
  return apiRequest("/api/user/me", {
    method: "GET",
  });
}

export function logoutUser() {
  localStorage.removeItem("token");
}

export function saveToken(token) {
  localStorage.setItem("token", token);
}

export function getToken() {
  return localStorage.getItem("token");
}