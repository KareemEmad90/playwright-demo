// src/utils/dbUtils.js
import oracledb from 'oracledb';

export async function queryDatabase(query, params = []) {
  const connection = await oracledb.getConnection({
    user: 'Traffic',
    password: 'traffic2',
    connectString: '172.18.125.129:1521/trfdv',
  });

  try {
    const result = await connection.execute(query, params);
    return result.rows;
  } catch (error) {
    console.error('Database query failed:', error);
    throw error;
  } finally {
    await connection.close();
  }
}

// Example Usage:
// const result = await queryDatabase('SELECT * FROM users WHERE id = :id', [123]);
