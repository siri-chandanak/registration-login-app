import { useNavigate } from "react-router-dom";

function Dashboard() {
  const navigate = useNavigate();

  const user = JSON.parse(localStorage.getItem("user"));

  const logout = () => {
    localStorage.removeItem("user");
    navigate("/login");
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        <h1>Dashboard</h1>

        {user ? (
          <>
            <h2>Welcome, {user.firstName}</h2>

            <button onClick={logout}>Logout</button>
          </>
        ) : (
          <p>You are not logged in.</p>
        )}
      </div>
    </div>
  );
}

export default Dashboard;