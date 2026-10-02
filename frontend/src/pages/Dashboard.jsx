import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  getCurrentUser,
  logoutUser,
} from "../services/authService";

function Dashboard() {
  const navigate = useNavigate();

  const [user, setUser] = useState(null);
  const [message, setMessage] = useState("Loading...");

  useEffect(() => {
    const loadUser = async () => {
      try {
        const data = await getCurrentUser();

        setUser(data);
        setMessage("");
      } catch (error) {
        logoutUser();
        navigate("/login");
      }
    };

    loadUser();
  }, [navigate]);

  const logout = () => {
    logoutUser();
    navigate("/login");
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        <h1>Dashboard</h1>

        {message && <p>{message}</p>}

        {user && (
          <>
            <h2>Welcome, {user.firstName}</h2>

            <button onClick={logout}>
              Logout
            </button>
          </>
        )}
      </div>
    </div>
  );
}

export default Dashboard;