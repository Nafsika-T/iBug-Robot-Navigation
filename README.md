# 🤖 iBug Robot Navigation

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

- `Main` → Builds the **EnvironmentDescription** (lamp/goal, 3 walls, box), places the `MyRobot` into the scene, and launches **Simbad**.  
- `MyRobot` → Extends `Agent`. In the constructor it creates **12 distance (sonar) sensors** around the robot and **3 light sensors** (center, front-left, front-right). Its `performBehavior` delegates to `iBug.step()`.  
- `Behaviors` → Helper behaviors used by the controller: `AlignmentGoal`, `MoveToGoal`, `CircumNavigate`, `LocalMax`, `zeroMax`, `Terminate`, `stop`.  
- `iBug` → The main controller: defines the **enum** with the 4 states, holds references to the robot & sensors, and implements `step()` to orchestrate the state transitions.  
- `Tools` → Utility methods used by `Behaviors`, e.g., `getSensedPoint` (compute obstacle hit point from sonars) and `wrapToPi` (normalize angle to [-π, π]).  

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
Check out the demo here: [video.mp4](video.mp4)


---

## 📝 License
This project is licensed under the MIT License.
