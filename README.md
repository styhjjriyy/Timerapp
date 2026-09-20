# Focus Timer App

A simple and clean Android timer application built using Kotlin and Jetpack Compose.

## About the App

Focus Timer is a simple productivity app that helps users focus on a task for a selected amount of time. 
The user can start, pause, reset, and change the timer duration using the quick duration options.

## Features

- Start and pause the timer
- Reset the timer
- Quick timer durations:
  - 5 minutes
  - 15 minutes
  - 25 minutes
- Circular progress indicator
- Shows remaining time in minutes and seconds
- Displays the current timer status
- Simple dark-themed user interface
- Responsive Compose-based UI

## Technologies Used

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Kotlin Coroutines

## How It Works

When the app starts, the timer is set to 25 minutes.

The user can:

1. Press **START TIMER** to start the countdown.
2. Press **PAUSE TIMER** to pause the countdown.
3. Press **RESET** to reset the timer to the selected duration.
4. Select **5 MIN**, **15 MIN**, or **25 MIN** to change the timer duration.

The circular progress indicator shows the remaining time visually.

## Project Structure

The main timer functionality is implemented in:

`MainActivity.kt`

The app uses Jetpack Compose to create the user interface.

## Purpose

This project was developed as an Android application practice project to learn Kotlin, Jetpack Compose, UI design, state management, and timer functionality.

## Current Status

Completed basic timer functionality.

## Author

Developed as an Android Studio project.
