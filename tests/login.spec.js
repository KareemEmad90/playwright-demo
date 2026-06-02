// tests/login.spec.js
import { test } from '@playwright/test';
import { LoginPage } from '../src/pages/LoginPage';

test.describe('Login Tests', () => {
  let loginPage;

  test.beforeEach(async ({ page }) => {
    loginPage = new LoginPage(page);
    await loginPage.goto();
  });

  test('Login with valid credentials', async ({ page }) => {
    await loginPage.login('validUser', 'validPassword');
    await loginPage.assertLoginSuccess();
  });

  test('Login with invalid credentials', async ({ page }) => {
    await loginPage.login('invalidUser', 'invalidPassword');
    const errorMessage = page.locator('.error-message');
    await expect(errorMessage).toHaveText('Invalid username or password');
  });
});
