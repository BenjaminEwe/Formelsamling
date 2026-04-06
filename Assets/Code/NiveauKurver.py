import numpy as np
import matplotlib.pyplot as plt
from matplotlib import cm

# 1. Setup the Coordinate Grid
# We use a grid from -3 to 3 for both axes
x = np.linspace(-3, 3, 100)
y = np.linspace(-3, 3, 100)
X, Y = np.meshgrid(x, y)

# 2. Define the Function for Multiple Peaks
# Using Gaussian-style peaks to simulate multiple paraboloid summits
def multi_peaks(X, Y):
    z1 = np.exp(-( (X-1)**2 + (Y-1)**2 ))
    z2 = 0.8 * np.exp(-( (X+1)**2 + (Y+1)**2 ))
    z3 = 0.6 * np.exp(-( (X-1)**2 + (Y+1)**2 ))
    z4 = 0.7 * np.exp(-( (X+1)**2 + (Y-1.5)**2 ))
    return z1 + z2 + z3 + z4

Z = multi_peaks(X, Y)

# 3. Create the Visualization
fig = plt.figure(figsize=(14, 6))

# --- Subplot 1: 3D Surface with Level Curves ---
ax1 = fig.add_subplot(1, 2, 1, projection='3d')
# Plot the translucent surface
surf = ax1.plot_surface(X, Y, Z, cmap='viridis', alpha=0.6, antialiased=True)
# Add contour lines (level curves) projected on the bottom plane
ax1.contour(X, Y, Z, zdir='z', offset=np.min(Z) - 0.2, cmap='viridis')

ax1.set_title("3D Peaks with Projected Level Curves")
ax1.set_xlabel("X (m)")
ax1.set_ylabel("Y (m)")
ax1.set_zlabel("Z (m)")
ax1.view_init(elev=25, azim=45) # Adjusting angle for better visibility

# --- Subplot 2: Flat 2D Contour Diagram ---
ax2 = fig.add_subplot(1, 2, 2)
# contourf creates filled level curves
contour = ax2.contourf(X, Y, Z, levels=15, cmap='viridis')
# Add a colorbar to relate colors to height values
fig.colorbar(contour, ax=ax2, label='Height Z (m)')

ax2.set_title("2D Flat Diagram of Level Curves (Contours)")
ax2.set_xlabel("X (m)")
ax2.set_ylabel("Y (m)")
ax2.grid(True, linestyle='--', alpha=0.5)

plt.tight_layout()
plt.show()