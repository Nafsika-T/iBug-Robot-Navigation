# 🤖 iBug Robot Navigation in Java

Implementation of the **i-Bug algorithm** for robot navigation in an unknown environment, developed in **Java** using the **Simbad 1.7** simulation platform and **Java3D**.

---

## 📖 Project Overview
This project demonstrates how a mobile robot can navigate towards a target in an unknown environment while avoiding obstacles, following the **i-Bug algorithm**.  
The algorithm ensures that the robot:
1. Moves towards the target while possible.
2. Switches to boundary-following behavior when obstacles are detected.
3. Returns to target-seeking mode when a viable path reopens.

---

## 🛠️ Technologies Used
- **Java**
- **Simbad 1.7**
- **Java3D**

---

## 📂 Project Structure
The project consists of **five main classes**:

- `Main` → Initializes the environment and starts the simulation.  
- `MyRobot` → Extends the Simbad robot class with custom behavior.  
- `iBug` → Implements the i-Bug navigation algorithm.  
- `Sensors` → Manages the robot’s proximity sensors and detection logic.  
- `Utils` → Helper methods for calculations (distances, angles, etc.).

---

## 🚀 How to Run
1. Install **Java 8 or later**.  
2. Download and set up **Simbad 1.7** and **Java3D**.  
3. Clone this repository:
   ```bash
   git clone https://github.com/your-username/iBug-Robot-Navigation-Java.git
   cd iBug-Robot-Navigation-Java
   ```
4. Compile and run:
   ```bash
   javac *.java
   java Main
   ```

---

## 🎯 Features
- Real-time simulation of robot navigation.  
- Obstacle detection with **8 proximity sensors**.  
- Dynamic switching between **target-seeking** and **boundary-following**.  
- Visualization in a 3D simulation environment.  

---

## 📸 Demo
*(Add screenshots or GIFs of the simulation here)*

---

## 📝 License
This project is licensed under the MIT License.
