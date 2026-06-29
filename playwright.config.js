// playwright.config.js
import { defineConfig } from '@playwright/test';

export default defineConfig({
  testDir: './tests',
  timeout: 30000,
  retries: 1,
  reporter: 'html',
  use: {
    headless: true,
    baseURL: 'http://localhost:3000', // Base URL for frontend app
    viewport: { width: 1280, height: 720 },
    actionTimeout: 5000,
    trace: 'retain-on-failure',
  },
});
